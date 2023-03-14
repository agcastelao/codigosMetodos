import java.util.Scanner;

public class linearRegression {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a quantidade de valores: ");
        int n = input.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.printf("Digite o valor de X%d: ", i+1);
            x[i] = input.nextDouble();

            System.out.printf("Digite o valor de Y%d: ", i+1);
            y[i] = input.nextDouble();

        }

        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;

        for (int i = 0; i < n; i++) {

            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] + y[i];
            sumX2 += x[i] * x[i];

        }

        double beta2 = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX); 
        double beta1 = (sumY - beta2 * sumX) / n; 

        double SQR = 0; 
        double SST = 0; 
        double yHat; 

        for (int i = 0; i < n; i++) {

            yHat = beta1 + beta2 * x[i];
            SQR += (y[i] - yHat) * (y[i] - yHat);
            SST += (y[i] - sumY/n) * (y[i] - sumY/n);

        }

        double r2 = 1 - SQR/SST; 
        double AIC = n * Math.log(SQR/n) + 2 * 2; 

        System.out.println("beta1 = " + beta1);
        System.out.println("beta2 = " + beta2);
        System.out.println("SQR = " + SQR);
        System.out.println("r2 = " + r2);
        System.out.println("AIC = " + AIC);
        
    }
}