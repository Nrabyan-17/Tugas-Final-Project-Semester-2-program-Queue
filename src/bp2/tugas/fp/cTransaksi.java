package bp2.tugas.fp;

public class cTransaksi {
    public String kodeTransaksi;
    private String namapembeli;
    private String statusTransaksi;
    private int jumlahBrg;
    private cBarang barang;
    cTransaksi next;
    
    cTransaksi(String kodeTrx, String namaPembeli, cBarang brg, int jumlahBarang, String statusTrx){
        kodeTransaksi=kodeTrx;
        namapembeli=namaPembeli;
        barang=brg;
        jumlahBrg=jumlahBarang;
        statusTransaksi=statusTrx;
        next=null;
    }
    public String getKodeTransaksi(){
        return kodeTransaksi;
    }
    public String getNamaPembeli(){
        return namapembeli;
    }
    public cBarang getBarang(){
        return barang;
    }
    public int getJumlahBarang(){
        return jumlahBrg;
    }
    public String getStatusTransaksi(){
        return statusTransaksi;
    }
    public void setStatusTransaksi(String statusTrx){
        statusTransaksi=statusTrx;
    }
}
