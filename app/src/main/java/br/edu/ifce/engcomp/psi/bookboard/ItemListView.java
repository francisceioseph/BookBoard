package br.edu.ifce.engcomp.psi.bookboard;

/**
 * Created by francisco on 13/01/15.
 */
public class ItemListView {
    String texto;
    int iconeRid;

    public ItemListView(){
        this(" ", -1);
    }

    public ItemListView(String texto, int iconeRid){
        this.texto = texto;
        this.iconeRid = iconeRid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getIconeRid() {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }
}
