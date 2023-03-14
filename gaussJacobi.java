public class gaussJacobi {
    
        public static void main(String[] args) {

            double[][] a = {{5, 1, 1}, {3, 4, 1}, {3, 3, 6}}; // matriz de coeficientes
            double[] b = {5, 6, 0}; // vetor de termos independente
            int n = b.length; // número de equações
    
            double[] x0 = new double[n]; // vetor de soluções iniciais
            double[] x1 = new double[n]; // vetor de soluções atualizadas
    
            double epsilon = 0.0001; // critério de parada
            int maxIter = 1000; // número máximo de iterações
    
            int iter = 0; // contador de iterações
            double error = Double.MAX_VALUE; // erro inicial
    
            while (error > epsilon && iter < maxIter) {

                for (int i = 0; i < n; i++) {

                    x1[i] = b[i] / a[i][i]; // solução inicial

                    for (int j = 0; j < n; j++) {

                        if (j != i) {

                            x1[i] -= x0[j] * a[i][j] / a[i][i]; // atualização da solução

                        }

                    }

                }

                error = 0;

                for (int i = 0; i < n; i++) {

                    error += Math.abs(x1[i] - x0[i]); // cálculo do erro
                    x0[i] = x1[i]; // atualização da solução anterior

                }

                iter++;

            }
    
            if (iter == maxIter) {

                System.out.println("Máximo de iterações atingido.");

            } 
            
            else {

                System.out.println("Solução encontrada após " + iter + " iterações:");

                for (int i = 0; i < n; i++) {

                    System.out.println("x" + i + " = " + x1[i]);

                }

            }

        }

    }

