import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;  
public class Password {
    public static String checkPassword(String password){
        int minimunPasswordSize = 6;
        String msg = "";
        
        //checa condicoes na password
        if(!(password.length() >= 6)){
            int howManyWordsMissing =  minimunPasswordSize - password.length();
            msg += "Precisa adicionar mais " + howManyWordsMissing + " caractere(s)!\n";
        }  
        if(!password.matches(".*[0-9].*")){
            msg += "Precisa ter 1 digito!\n";
        }  
        if(!password.matches(".*[a-z].*")){
            msg += "Precisa ter 1 letra minúscula!\n";
        }  
        if(!password.matches(".*[A-Z].*")){
            msg += "Precisa ter 1 letra maiscúla!\n";
        }  
        if(!password.matches(".*[!@#$%^&*()-+].*")){
            msg += "Precisa ter 1 caractere especial!(?=.*[!@#$%^&*()-+)\n";
        } 

        // se passar em tudo, retorna a msg senha segura
        if(msg.isEmpty()){
            msg = "Senha segura";
        }
        return msg;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String password = "";
        System.out.println("Digite a senha: ");
        password = sc.nextLine();
        System.out.println(checkPassword(password));
        sc.close();
    }

    @Test
    public void testPyramide(){
       assertEquals("Senha segura", checkPassword("Ya3&ab"));
       assertEquals("Precisa adicionar mais 3 caractere(s)!\n" + "Precisa ter 1 caractere especial!(?=.*[!@#$%^&*()-+)\n", checkPassword("Ya3"));
       assertEquals("Precisa ter 1 letra minúscula!\n" + "Precisa ter 1 letra maiscúla!\n" + "Precisa ter 1 caractere especial!(?=.*[!@#$%^&*()-+)\n" , checkPassword("123456"));
       assertEquals("Senha segura", checkPassword("AAA3@b"));
    }
}
