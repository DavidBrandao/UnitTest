import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MatrizTest {

    @Test
    void getLinScanner(){
        String m = "2 2 1 2 3 4 ";
        Matriz mat = new Matriz(new Scanner(m));
        assertEquals(mat.getLin(), 2);
    }

    @Test
    void clonarMatrizConstrutor(){
        //matriz principal
        String m = "2 2 1 2 3 4 ";
        Matriz mat = new Matriz(new Scanner(m));

        //matriz clonada
        Matriz mat2 = new Matriz(mat);

        //Verificar se matrizes possuem mesma quantidade de linhas e colunas
        assertEquals(mat.getLin(),mat2.getLin());
        assertEquals(mat.getColun(), mat2.getColun());

        //Verificar se os elmentos das matrizes são iguais
        assertEquals(mat.getElemento(1,1), mat2.getElemento(1,1));
        assertEquals(mat.getElemento(1,2), mat2.getElemento(1,2));
        assertEquals(mat.getElemento(2,1), mat2.getElemento(2,1));
        assertEquals(mat.getElemento(2,2), mat2.getElemento(2,2));
    }

    @Test
    void getLin() {
        Matriz m = new Matriz(3,5);
        assertEquals(m.getLin(),3);
    }

    @Test
    void getColun() {
        Matriz m = new Matriz(3,5);
        assertEquals(m.getColun(),5);
    }

    @Test
    void getElemento() {
        Matriz m = new Matriz(3,5);
        assertEquals(m.getElemento(1,1), 0);
    }

    @Test
    void setElemento() {
        Matriz m = new Matriz(3,5);
        m.setElemento(1,1,15);
        assertEquals(m.getElemento(1,1), 15);
    }

    @Test
    void negar() {
        Matriz m = new Matriz(2,2);
        m.setElemento(1,1,10);
        m.setElemento(2,1,20);

        m.negar();

        System.out.println(m.getElemento(1,1));
        System.out.println(m.getElemento(2,1));

        assertEquals(m.getElemento(1,1), -10);
        assertEquals(m.getElemento(2,1), -20);
    }

    @Test
    void multiplicar() {
        Matriz m = new Matriz(2,2); //10 0
        m.setElemento(1,1,10);     //0 0

        Matriz m2 = m.multiplicar(2, m);
        assertEquals(m2.getElemento(1,1), 20);
    }

    @Test
    void comparaIgual() {
        Matriz m1 = new Matriz(2,2);
        m1.setElemento(1,1,10);

        Matriz m2 = new Matriz(2,2);
        m2.setElemento(1,1,10);

        //assertEquals(m1.getElemento(1,1), m2.getElemento(1,1));
        assertTrue(m1.comparaIgual(m2));
    }

    @Test
    void comparaIgualFalseScenario(){
        Matriz m1 = new Matriz(2,2);
        m1.setElemento(1,1,10);

        Matriz m2 = new Matriz(2,2);
        m2.setElemento(1,1,11);

        //assertEquals(m1.getElemento(1,1), m2.getElemento(1,1));
        assertFalse(m1.comparaIgual(m2));
    }

    @Test
    void somar() {
        Matriz m1 = new Matriz(2,2);
        m1.setElemento(1,1,10);

        Matriz m2 = new Matriz(2,2);
        m2.setElemento(1,1,20);

        Matriz m3 = new Matriz(2,2);

        System.out.println(m3.getElemento(1,1));
    }

    @Test
    void somarMatrizTamanhoDiferente(){
        String m = "2 2 1 2 3 4 ";
        Matriz mat = new Matriz(new Scanner(m));

        String m2 = "3 3 1 2 3 4 5 6 7 8 9 ";
        Matriz mat2 = new Matriz(new Scanner(m2));

        assertNull(mat.somar(mat2, mat));
    }
}