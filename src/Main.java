public class Main {
    public static void main(String[] args) {
        IModel armazem=new Armazem();
        armazem.init();
        IControllerGestor cg = new ControllerGestor(armazem);
        IControllerFuncionario cf = new ControllerFuncionario(armazem);
        IControllerTecnico ct = new ControllerTecnico(armazem);
        IViewerGeral vg = new ViewGeral(ct,cg,cf);

        vg.run();
    }
}
