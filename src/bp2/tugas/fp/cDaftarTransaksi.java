package bp2.tugas.fp;

public class cDaftarTransaksi {
    cTransaksi front;
    cTransaksi rear;
    private int jumlah;
    
    cDaftarTransaksi(){
        front=null; rear=null; jumlah=0;
    }
    public cTransaksi getFront(){
        return front;
    }
    public cTransaksi getRear(){
        return rear;
    }
    public void tambah(cTransaksi databaru){
        if(rear==null){
            front=rear=databaru;
        }else{
            rear.next=databaru;
            rear=databaru;
        }
        System.out.println("Penambahan data berhasil..");  
    }
    public void hapus(int nomor){
        cTransaksi temp=front;
        cTransaksi prev=null;
        
        int i=1;
        
        if(nomor==1){
            if(temp.next==null){//artinya jika transaksi hanya tersisa1
                front=null;
                rear=null;
            }else{
                front=front.next;
                temp.next=null;
            }
            System.out.println("["+temp.getBarang().getNamaBarang()+"] telah berhasil dihapus!!");
        }else{
            for (;temp!=null; temp=temp.next) {
                if(i==nomor){
                    break;
                }i++;prev=temp;
                
            }if(temp.next==null){// yang dihapus bagian ujung belakang
                rear=prev;
                rear.next=null;
            }else{
                prev.next=temp.next;
                temp.next=null;
            }
            System.out.println("["+temp.getBarang().getNamaBarang()+"] telah berhasil dihapus!!");
        }
    }
    public void lihat(){
        int i = 1;
        int total=0;
        System.out.println("=======================================================================================");
        System.out.println("---------------------------------Daftar Transaksi-----------------------------");
        System.out.printf("%-3s %-15s %-15s %-15s %-7s %-7s %-10s\n", "No.","Kode Transaksi", "Nama Pembeli",
                "Nama Menu","Harga","Jumlah","Status Transaksi");
        for (cTransaksi temp = front;temp!=null;temp=temp.next) {
            System.out.printf("%-3d %-15s %-15s %-15s %-7d %-7d %-10s\n", i,temp.getKodeTransaksi(),
                    temp.getNamaPembeli(),temp.getBarang().getNamaBarang(), temp.getBarang().getHargaBarang(),
                    temp.getJumlahBarang(),temp.getStatusTransaksi());
            i++;
        }
        System.out.println("=======================================================================================");
    }
    public void lihatTransaksiMember(){
        int i=1;
        double total=0,diskon;
        System.out.println("=======================================================================================");
        System.out.println("---------------------------------Daftar Transaksi Member-----------------------------");
        System.out.printf("%-3s %-15s %-15s %-15s %-7s %-7s %-10s\n", "No.","Kode Transaksi", "Nama Pembeli",
                "Nama Menu","Harga","Jumlah","Status Transaksi");
        for (cTransaksi temp = front;temp!=null;temp=temp.next) {
            System.out.printf("%-3d %-15s %-15s %-15s %-7d %-7d %-10s\n", i,temp.getKodeTransaksi(),
                    temp.getNamaPembeli(),temp.getBarang().getNamaBarang(), temp.getBarang().getHargaBarang(),
                    temp.getJumlahBarang(),temp.getStatusTransaksi());
            i++;
            total=total+(temp.getBarang().getHargaBarang()*temp.getJumlahBarang());
        }
        System.out.println("Total Pembelian: "+total);
        System.out.println("Diskon         : "+(0.1*total));
        System.out.println("Grand Total    : "+(total-(0.1*total)));
        System.out.println("=======================================================================================");
    }
    public void lihatAdmin() {
        int i = 1;
        System.out.println("=======================================================================================");
        System.out.println("---------------------------------Transaksi Belum Diproses-----------------------------");
        System.out.printf("%-3s %-15s %-15s %-15s %-7s %-7s %-10s\n", "No.", "Kode Transaksi", "Nama Pembeli",
                "Nama Menu", "Harga", "Jumlah", "Status Transaksi");
        for (cTransaksi temp = front; temp != null; temp = temp.next) {
            if (temp.getStatusTransaksi() == "Belum diproses") {
                System.out.printf("%-3d %-15s %-15s %-15s %-7d %-7d %-10s\n", i, temp.getKodeTransaksi(),
                        temp.getNamaPembeli(), temp.getBarang().getNamaBarang(), temp.getBarang().getHargaBarang(),
                        temp.getJumlahBarang(), temp.getStatusTransaksi());
                i++;
            }
        }
        System.out.println("=======================================================================================");
    }
    
    public void sambungTransaksi(cTransaksi depan, cTransaksi belakang){
        //menyambungkan rear transaksi pembeli ke front transaksi toko
        if(rear==null){//transaksi masih kosong
            front=depan;
            rear=belakang;
        }else{
            //sambung transaksi pembeli ke transaksi toko
            rear.next=depan;
            //mengubah posisi rear yang baru
            rear=belakang;
        }
    }
    public void prosesTransaksi(cTransaksi temp){
        temp.setStatusTransaksi("Sudah diproses");
    }
    public int lihatProsesTransaksi(){//untuk owner
        cTransaksi temp = front;
        int proses = 0;
        
        for (; temp!=null; temp=temp.next) {
            if(temp.getStatusTransaksi()=="Sudah diproses"){
                proses++;
            }
        }
        return proses;
    }
    public double lihatPemasukan(){//untuk owner
        cTransaksi temp=front;
        double nominal = 0;
        
        for (; temp!=null; temp=temp.next) {
            if(temp.getStatusTransaksi()=="Sudah diproses"){
                nominal = nominal+temp.getBarang().getHargaBarang()*temp.getJumlahBarang();
                if(temp.getNamaPembeli().compareToIgnoreCase("100")==00||
                        temp.getNamaPembeli().compareToIgnoreCase("101")==00||temp.getNamaPembeli().compareToIgnoreCase("102")==00){
                    nominal=nominal-(0.1*nominal);
                }
                    
            }
        }
        return nominal;
    }
}
