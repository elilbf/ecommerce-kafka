package br.com.alura.ecommerce.ecommerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderServlet extends HttpServlet {

    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();
    private final KafkaDispatcher<String> emailDispatcher = new KafkaDispatcher<>();

    @Override
    public void destroy() {
        super.destroy();
        orderDispatcher.close();
        emailDispatcher.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //we are not caring about any security issues, we are only showing how to use http as a stating point
            var email = req.getParameter("email");
            var amount = new BigDecimal(req.getParameter("amount"));
            var orderId = UUID.randomUUID().toString();

            var order = new Order(orderId, amount, email);
            orderDispatcher.send("ECOMMERCE_NEW_ORDER", email,
                    new CorrelationId(NewOrderServlet.class.getSimpleName()),
                    order);

            var emailCode = "Thank you! We are processing your order!";
            emailDispatcher.send("ECOMMERCE_SEND_EMAIL", email,
                    new CorrelationId(NewOrderServlet.class.getSimpleName()),
                    emailCode);

            System.out.println("New Order sent successfully.");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("New Order sent successfully.");
        } catch (ExecutionException e) {
            throw new ServletException(e);
        } catch (InterruptedException e) {
            throw new ServletException(e);
        }
    }

}
