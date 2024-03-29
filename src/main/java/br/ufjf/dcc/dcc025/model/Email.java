package br.ufjf.dcc.dcc025.model;

import br.ufjf.dcc.dcc025.exception.EmailException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Alunos
    Daniel Keim Almeida - 202165021AB
    Davi Monken Ekchardt - 202265019A
    Gabriel Cordeiro Tavares - 202265163A
*/

public class Email {

    private String email;
    private String login;
    private String dominio;


    public Email(String text) throws EmailException {
        setEmail(text);
    }
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {
        if(!isValidEmail(email))
            throw new EmailException();

        this.email = email;
        String[] partes = email.split("@");

        this.login = partes[0];
        this.dominio = partes[1];
    }

    public String getLogin() {
        return login;
    }

    public String getDominio() {
        return dominio;
    }

}
