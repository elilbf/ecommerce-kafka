package br.com.alura.ecommerce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    private final String uuid;

    public String getReportPath() {
        return "target/" + uuid + "-report.txt";
    }

}
