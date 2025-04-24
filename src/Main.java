package src;

import java.util.ArrayList;
import src.models.Funcionario;
import src.Menu;

public class Main{
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        menu.menu(funcionarios);
    }

}