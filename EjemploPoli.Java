public class EjemploPoli {

    public static void main(String[] args) {
        Triangulo fig = new Triangulo();
        Cuadro fig2 = new Cuadro();
        Circulo fig3 = new Circulo();

        fig.dibujar();
        fig2.dibujar();
        fig3.dibujar();

        Figura [] figus = new Figura[3];
        figus[0] = new Circulo();
        figus[1] = new Triangulo();
        figus[2] = new Cuadro();

        for (Figura f : figus) {
            f.dibujar();
        }
    }
}

class Figura {
    public void dibujar() {
        System.out.println("Dibujando una figura");
    }
}

class Circulo extends Figura {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un circulo");
    }
}

class Triangulo extends Figura {
    public void dibujar() {
        System.out.println("dibujando un triangulo");
    }
}

class Cuadro extends Figura {
    @Override
    public void dibujar() {
        System.out.println("dibujando un cuadro");
    }
}