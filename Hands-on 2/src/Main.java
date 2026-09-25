public class Main {

    public static void main(String[] args) {

        // ==========================================
        // PATRONES DE ENTRENAMIENTO DE LA COMPUERTA OR
        // ==========================================

        // Estos son los cuatro posibles patrones
        // de entrada para una compuerta logica OR
        double[][] entradas = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };


        // ==========================================
        // SALIDAS ESPERADAS
        // ==========================================

        // La compuerta OR produce uno cuando
        // al menos una de las entradas tiene valor uno
        int[] salidasEsperadas = {
            0,
            1,
            1,
            1
        };


        // ==========================================
        // PARAMETROS INICIALES
        // ==========================================

        // Se establece la velocidad de aprendizaje
        // Este valor controla el tamaño de las actualizaciones
        double velocidadAprendizaje = 0.1;


        // ==========================================
        // CREACION DEL PERCEPTRON
        // ==========================================

        // Se crean los parametros iniciales
        // w1 = 0
        // w2 = 0
        // b  = 0
        // velocidad = 0.1
        Perceptron perceptron =
                new Perceptron(
                        0,
                        0,
                        0,
                        velocidadAprendizaje
                );


        // ==========================================
        // ENTRENAMIENTO
        // ==========================================

        // Se envian los patrones y las salidas esperadas
        // al metodo de entrenamiento
        perceptron.entrenar(
                entradas,
                salidasEsperadas
        );


        // ==========================================
        // MOSTRAR PARAMETROS OPTIMOS
        // ==========================================

        System.out.println();
        System.out.println();
        System.out.println("======================================");
        System.out.println("       VALORES OPTIMOS DEL PERCEPTRON");
        System.out.println("======================================");

        // Muestra el valor final de w1
        System.out.println(
            "w1 = " + perceptron.getW1()
        );

        // Muestra el valor final de w2
        System.out.println(
            "w2 = " + perceptron.getW2()
        );

        // Muestra el valor final del bias
        System.out.println(
            "b  = " + perceptron.getB()
        );

        // Muestra la velocidad de aprendizaje utilizada
        System.out.println(
            "Velocidad de aprendizaje = " +
            perceptron.getVelocidadAprendizaje()
        );


        // ==========================================
        // COMPROBACION FINAL DE LOS PATRONES
        // ==========================================

        System.out.println();
        System.out.println("======================================");
        System.out.println("       COMPROBACION FINAL");
        System.out.println("======================================");


        // Recorre nuevamente todos los patrones
        // utilizando los valores finales aprendidos
        for (int i = 0; i < entradas.length; i++) {

            // Obtiene x1 del patron actual
            double x1 = entradas[i][0];

            // Obtiene x2 del patron actual
            double x2 = entradas[i][1];

            // Obtiene la salida esperada
            int salidaEsperada =
                    salidasEsperadas[i];


            // ==========================================
            // CALCULAR LA SUMA PONDERADA
            // ==========================================

            // Aplica la formula
            // z = w1*x1 + w2*x2 + b
            double sumaPonderada =
                    perceptron.calcularSumaPonderada(
                            x1,
                            x2
                    );


            // ==========================================
            // APLICAR FUNCION DE ACTIVACION
            // ==========================================

            // Convierte la suma ponderada en
            // una salida de cero o uno
            int salidaObtenida =
                    perceptron.funcionActivacion(
                            sumaPonderada
                    );


            // ==========================================
            // MOSTRAR INFORMACION
            // ==========================================

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("Patron " + (i + 1));
            System.out.println("--------------------------------------");

            System.out.println(
                "x1 = " + x1
            );

            System.out.println(
                "x2 = " + x2
            );


            // ==========================================
            // MOSTRAR CALCULO DE LA SUMA PONDERADA
            // ==========================================

            System.out.println();
            System.out.println(
                "Suma Ponderada:"
            );

            System.out.println(
                "(" + x1 + " * " +
                perceptron.getW1() + ") + (" +
                x2 + " * " +
                perceptron.getW2() + ") + (" +
                perceptron.getB() + ")"
            );

            System.out.println(
                "= " + sumaPonderada
            );


            // ==========================================
            // MOSTRAR FUNCION DE ACTIVACION
            // ==========================================

            System.out.println();
            System.out.println(
                "Funcion de Activacion:"
            );


            // La funcion escalon produce uno cuando
            // la suma ponderada es mayor o igual a cero
            if (sumaPonderada >= 0) {

                System.out.println(
                    "Como " + sumaPonderada +
                    " >= 0, entonces f(z) = 1"
                );

            } else {

                System.out.println(
                    "Como " + sumaPonderada +
                    " < 0, entonces f(z) = 0"
                );
            }


            // ==========================================
            // MOSTRAR RESULTADOS
            // ==========================================

            System.out.println(
                "Salida obtenida = " +
                salidaObtenida
            );

            System.out.println(
                "Salida esperada = " +
                salidaEsperada
            );


            // ==========================================
            // COMPROBAR CLASIFICACION
            // ==========================================

            // Compara la salida obtenida con la esperada
            if (salidaObtenida == salidaEsperada) {

                System.out.println(
                    "Resultado: CORRECTO"
                );

            } else {

                System.out.println(
                    "Resultado: INCORRECTO"
                );
            }
        }


        // ==========================================
        // TABLA FINAL DE LA COMPUERTA OR
        // ==========================================

        System.out.println();
        System.out.println();
        System.out.println("======================================");
        System.out.println("       TABLA FINAL DE RESULTADOS");
        System.out.println("======================================");

        System.out.println(
            "x1\tx2\tEsperado\tObtenido"
        );


        // Recorre todos los patrones para construir
        // la tabla final de resultados
        for (int i = 0; i < entradas.length; i++) {

            // Obtiene x1
            double x1 = entradas[i][0];

            // Obtiene x2
            double x2 = entradas[i][1];


            // Calcula la suma ponderada con
            // los pesos finales del perceptron
            double sumaPonderada =
                    perceptron.calcularSumaPonderada(
                            x1,
                            x2
                    );


            // Aplica la funcion de activacion
            int resultado =
                    perceptron.funcionActivacion(
                            sumaPonderada
                    );


            // Muestra los resultados en forma de tabla
            System.out.println(
                x1 + "\t" +
                x2 + "\t" +
                salidasEsperadas[i] + "\t\t" +
                resultado
            );
        }
    }
}