package lunainc.com.mx.Test4;

import java.util.ArrayList;

/**
 * 4.-Realizar un método que reciba un parámetro genérico (object) y dependiendo del
 * tipo de objeto imprimir
 *  • String: “Eres una palabra”
 *  • Integer,Long, etc : “eres un numero”
 *  • List, ArrayList, etc: “eres una lista”
 *  • Otro: “Eres de otro tipo”
 */

public class Main {


    public static void main(String[] args) {

        Generic<Integer> iOb;
        Generic<String> iOb2;
        Generic<ArrayList> iOb3;
        Generic<Boolean> iOb4;

        iOb= new Generic<Integer>(28);
        iOb.showType();


        iOb2 = new Generic<String>("Hello");
        iOb2.showType();

        iOb3 = new Generic<ArrayList>(new ArrayList<String>());
        iOb3.showType();

        iOb4 = new Generic<Boolean>(true);
        iOb4.showType();


    }

}
