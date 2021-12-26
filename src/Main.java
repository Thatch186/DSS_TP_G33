public class Main {
    public static void main(String[] args) {
        Contacto c1 = new Contacto("c1@gmail.com","912345789");
        Contacto c2 = new Contacto("c2@gmail.com","922345789");
        Contacto c3 = new Contacto("c3@gmail.com","932345789");
        Contacto c4 = new Contacto("c4@gmail.com","942345789");

        Cliente cliente1 = new Cliente(1,c1);
        Cliente cliente2 = new Cliente(2,c2);
        Cliente cliente3 = new Cliente(3,c3);
        Cliente cliente4 = new Cliente(4,c4);

        Equipamento e1 = new Equipamento("equipamento1");
        Equipamento e2 = new Equipamento("equipamento2");
        Equipamento e3 = new Equipamento("equipamento3");
        Equipamento e4 = new Equipamento("equipamento4");

        Estatisticas estatisticas = new Estatisticas();
        Funcionario f = new Funcionario(1);

        cliente1.pedeOrcamento(e1,f,false);
        cliente2.pedeOrcamento(e2,f,false);
        cliente3.pedeOrcamento(e3,f,true);
        cliente4.pedeOrcamento(e4,f,true);



        for(Equipamento e: cliente1.getEquip_list()){
            System.out.println(e);
        }

        System.out.println("Deu");



        for(Equipamento e: cliente1.getEquip_list()){
            System.out.println(e);
        }

        f.printArmazem();


    }
}
