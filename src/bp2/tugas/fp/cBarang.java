package bp2.tugas.fp;

public class cBarang {
    public String namaBrg;
    private int hargaBrg;
    
    cBarang(String nama,int harga){
        namaBrg=nama; hargaBrg=harga;
    }
    
    public String getNamaBarang(){
        return namaBrg;
    }
    public void setNamaBarang(String nama){
        namaBrg=nama;
    }
    public int getHargaBarang(){
        return hargaBrg;
    }
    public void setHargaBarang(int harga){
        hargaBrg=harga;
    }
}
