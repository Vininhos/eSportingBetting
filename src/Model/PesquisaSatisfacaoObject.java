/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vinni
 */
public class PesquisaSatisfacaoObject {

    private int pontosPergunta1;
    private int pontosPergunta2;
    private int pontosPergunta3;
    private int pontosPergunta4;
    private int pontosPergunta5;

    public PesquisaSatisfacaoObject() {
    }

    public PesquisaSatisfacaoObject(int pontosPergunta1, int pontosPergunta2, int pontosPergunta3, int pontosPergunta4, int pontosPergunta5) {
        this.pontosPergunta1 = pontosPergunta1;
        this.pontosPergunta2 = pontosPergunta2;
        this.pontosPergunta3 = pontosPergunta3;
        this.pontosPergunta4 = pontosPergunta4;
        this.pontosPergunta5 = pontosPergunta5;
    }

    public int getPontosPergunta1() {
        return pontosPergunta1;
    }

    public void setPontosPergunta1(int pontosPergunta1) {
        this.pontosPergunta1 = pontosPergunta1;
    }

    public int getPontosPergunta2() {
        return pontosPergunta2;
    }

    public void setPontosPergunta2(int pontosPergunta2) {
        this.pontosPergunta2 = pontosPergunta2;
    }

    public int getPontosPergunta3() {
        return pontosPergunta3;
    }

    public void setPontosPergunta3(int pontosPergunta3) {
        this.pontosPergunta3 = pontosPergunta3;
    }

    public int getPontosPergunta4() {
        return pontosPergunta4;
    }

    public void setPontosPergunta4(int pontosPergunta4) {
        this.pontosPergunta4 = pontosPergunta4;
    }

    public int getPontosPergunta5() {
        return pontosPergunta5;
    }

    public void setPontosPergunta5(int pontosPergunta5) {
        this.pontosPergunta5 = pontosPergunta5;
    }

    @Override
    public String toString() {
        return "PesquisaSatisfacaoObject{" + "pontosPergunta1=" + pontosPergunta1 + ", pontosPergunta2=" + pontosPergunta2 + ", pontosPergunta3=" + pontosPergunta3 + ", pontosPergunta4=" + pontosPergunta4 + ", pontosPergunta5=" + pontosPergunta5 + '}';
    }

}
