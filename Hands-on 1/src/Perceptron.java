public class Perceptron {

    // ============================================================
    // ATRIBUTOS DEL PERCEPTRON
    // ============================================================

    // Peso correspondiente a la primera entrada x1
    // Este valor determina la importancia de x1 en el calculo
    private double w1;

    // Peso correspondiente a la segunda entrada x2
    // Este valor determina la importancia de x2 en el calculo
    private double w2;

    // Bias del perceptron
    // El bias permite desplazar el limite de decision del clasificador
    private double b;


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    // El constructor recibe los valores iniciales de los parametros
    // Los valores se reciben directamente desde el codigo fuente
    public Perceptron(double w1, double w2, double b) {

        // Inicializa el primer peso
        this.w1 = w1;

        // Inicializa el segundo peso
        this.w2 = w2;

        // Inicializa el bias
        this.b = b;
    }


    // ============================================================
    // SUMA PONDERADA
    // ============================================================

    // Este metodo calcula la suma ponderada del perceptron
    // La formula utilizada es z = w1*x1 + w2*x2 + b
    public double calcularSumaPonderada(double x1, double x2) {

        // Multiplica la primera entrada por su peso
        // Multiplica la segunda entrada por su peso
        // Finalmente agrega el valor del bias
        return (w1 * x1) + (w2 * x2) + b;
    }


    // ============================================================
    // FUNCION DE ACTIVACION
    // ============================================================

    // Este metodo utiliza una funcion de activacion escalon
    // La funcion convierte la suma ponderada en una salida de 0 o 1
    public int funcionActivacion(double sumaPonderada) {

        // Si la suma ponderada es mayor o igual a cero
        // El perceptron produce una salida de uno
        if (sumaPonderada >= 0) {

            return 1;

        } else {

            // Si la suma ponderada es menor que cero
            // El perceptron produce una salida de cero
            return 0;
        }
    }


    // ============================================================
    // ENTRENAMIENTO DEL PERCEPTRON
    // ============================================================

    // Este metodo entrena el perceptron utilizando los patrones
    // Las entradas contienen los valores de x1 y x2
    // Las salidas esperadas contienen el resultado correcto
    public void entrenar(
            double[][] entradas,
            int[] salidasEsperadas) {

        // Esta variable indica si el perceptron ya aprendio
        // Al comenzar el entrenamiento se establece como falso
        boolean aprendio = false;

        // Esta variable permite contar las epocas de entrenamiento
        int epoca = 0;


        // ========================================================
        // CICLO PRINCIPAL DE ENTRENAMIENTO
        // ========================================================

        // El entrenamiento continua mientras el perceptron no haya
        // clasificado correctamente todos los patrones
        while (!aprendio) {

            // Aumenta el numero de epoca
            epoca++;

            // Al comenzar una epoca se supone que ya aprendio
            // Si posteriormente aparece un error esta variable
            // volvera a cambiar a falso
            aprendio = true;


            // ====================================================
            // MOSTRAR INFORMACION DE LA EPOCA
            // ====================================================

            System.out.println();
            System.out.println("======================================");
            System.out.println("EPOCA " + epoca);
            System.out.println("======================================");


            // ====================================================
            // RECORRER TODOS LOS PATRONES
            // ====================================================

            // Recorre cada uno de los patrones de entrenamiento
            for (int i = 0; i < entradas.length; i++) {

                // Obtiene el valor de x1 del patron actual
                double x1 = entradas[i][0];

                // Obtiene el valor de x2 del patron actual
                double x2 = entradas[i][1];

                // Obtiene el resultado correcto para el patron
                int salidaEsperada = salidasEsperadas[i];


                // =================================================
                // CALCULAR LA SUMA PONDERADA
                // =================================================

                // Calcula z utilizando los pesos actuales
                // La operacion realizada es
                // z = w1*x1 + w2*x2 + b
                double sumaPonderada =
                        calcularSumaPonderada(x1, x2);


                // =================================================
                // APLICAR LA FUNCION DE ACTIVACION
                // =================================================

                // Convierte la suma ponderada en una salida
                // La salida solamente puede ser cero o uno
                int salidaObtenida =
                        funcionActivacion(sumaPonderada);


                // =================================================
                // CALCULAR EL ERROR
                // =================================================

                // El error se obtiene restando la salida obtenida
                // de la salida esperada
                // error = salida esperada - salida obtenida
                int error =
                        salidaEsperada - salidaObtenida;


                // =================================================
                // MOSTRAR INFORMACION DEL PATRON
                // =================================================

                System.out.println();
                System.out.println("Patron " + (i + 1));

                // Muestra el valor de la primera entrada
                System.out.println("x1 = " + x1);

                // Muestra el valor de la segunda entrada
                System.out.println("x2 = " + x2);

                // Muestra la suma ponderada
                System.out.println(
                    "Suma ponderada = " + sumaPonderada
                );

                // Muestra el resultado de la funcion de activacion
                System.out.println(
                    "Funcion de activacion = " + salidaObtenida
                );

                // Muestra el resultado que deberia obtener
                System.out.println(
                    "Salida esperada = " + salidaEsperada
                );

                // Muestra el resultado producido por el perceptron
                System.out.println(
                    "Salida obtenida = " + salidaObtenida
                );

                // Muestra el error calculado
                System.out.println(
                    "Error = " + error
                );


                // =================================================
                // ACTUALIZACION DE LOS PARAMETROS
                // =================================================

                // Si el error es diferente de cero
                // Significa que el perceptron clasifico incorrectamente
                if (error != 0) {

                    System.out.println(
                        "Se actualizaran los parametros."
                    );


                    // =================================================
                    // ACTUALIZACION DE w1
                    // =================================================

                    // Se muestra la formula utilizada para actualizar
                    // el primer peso
                    System.out.println(
                        "w1 = " + w1 +
                        " + (" + error + " * " + x1 + ")"
                    );


                    // =================================================
                    // ACTUALIZACION DE w2
                    // =================================================

                    // Se muestra la formula utilizada para actualizar
                    // el segundo peso
                    System.out.println(
                        "w2 = " + w2 +
                        " + (" + error + " * " + x2 + ")"
                    );


                    // =================================================
                    // ACTUALIZACION DEL BIAS
                    // =================================================

                    // El bias se actualiza utilizando solamente el error
                    System.out.println(
                        "b = " + b +
                        " + " + error
                    );


                    // =================================================
                    // REGLA DE ACTUALIZACION DE LOS PESOS
                    // =================================================

                    // Actualizacion del primer peso
                    // w1 = w1 + error*x1
                    w1 = w1 + (error * x1);

                    // Actualizacion del segundo peso
                    // w2 = w2 + error*x2
                    w2 = w2 + (error * x2);

                    // Actualizacion del bias
                    // b = b + error
                    b = b + error;


                    // =================================================
                    // MOSTRAR LOS NUEVOS VALORES
                    // =================================================

                    System.out.println();
                    System.out.println("Nuevos valores:");

                    // Muestra el nuevo valor de w1
                    System.out.println("w1 = " + w1);

                    // Muestra el nuevo valor de w2
                    System.out.println("w2 = " + w2);

                    // Muestra el nuevo valor del bias
                    System.out.println("b = " + b);


                    // =================================================
                    // INDICAR QUE TODAVIA NO HA APRENDIDO
                    // =================================================

                    // Como hubo un error el perceptron todavia necesita
                    // continuar con el entrenamiento
                    aprendio = false;

                } else {

                    // =================================================
                    // EL PATRON FUE CLASIFICADO CORRECTAMENTE
                    // =================================================

                    // Si el error es cero significa que la salida
                    // obtenida coincide con la salida esperada
                    System.out.println(
                        "Clasificacion correcta. " +
                        "No se actualizan los parametros."
                    );
                }
            }
        }


        // ============================================================
        // FIN DEL ENTRENAMIENTO
        // ============================================================

        // Si el programa llega aqui significa que todos los patrones
        // fueron clasificados correctamente en una epoca completa
        System.out.println();
        System.out.println("======================================");
        System.out.println("PERCEPTRON CONVERGIO");
        System.out.println("======================================");

        // Muestra cuantas epocas fueron necesarias para converger
        System.out.println(
            "Numero de epocas: " + epoca
        );
    }


    // ============================================================
    // METODOS GET PARA LOS PESOS Y EL BIAS
    // ============================================================

    // Este metodo permite consultar el valor actual de w1
    // El atributo w1 permanece privado dentro de la clase
    public double getW1() {

        return w1;
    }


    // Este metodo permite consultar el valor actual de w2
    // El atributo w2 permanece privado dentro de la clase
    public double getW2() {

        return w2;
    }


    // Este metodo permite consultar el valor actual del bias
    // El atributo b permanece privado dentro de la clase
    public double getB() {

        return b;
    }
}