package peru.bank;
import java.util.Scanner;
public class PeruBank {
 
    private double saldo;
    public void Peru_Bank(double monto){
        this.saldo += monto;
    }
    public void deposito(double monto)
    {
        this.saldo += monto;
    }
    public void retiro(double monto)
    {
        this.saldo -= monto;
    }
    public double consulta()
    {
        return this.saldo;
    }
    
    int entrada_dni,entrada_password, veces = 0;
    int dni = 76185307;
    int password = 123456;    
    String nombres [] = {"Rene Robiñho"};
    
     public void Entrada(){
     do{ 
        System.out.println("--------- NEW PERU BANK-------");
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese su dni: ");
        entrada_dni = teclado.nextInt();
        System.out.print("Ingrese su contraseña: ");
        entrada_password = teclado.nextInt();
            if (entrada_dni == dni && entrada_password == password){
                System.out.println("Bienvenido " + nombres[0]);
                PeruBank ver = new PeruBank();
                ver.Opciones();
                veces = 3;}
            else{
                System.out.println("Dni o contraseña incorrecto.");
                veces = veces+1;
            if (veces ==3){
                    System.out.println("Bloqueado");} 
            }
    }while(veces < 3);
  }
    
    public void Opciones(){
        int opcion=0;
        double otraOpcion;
        Scanner teclado = new Scanner(System.in);
        otraOpcion = 0;
        PeruBank Cuenta = new Peru_Bank(otraOpcion);
        while(opcion!=4)
        {
        System.out.println("\t--------- NEW PERU BANK-------");
        System.out.println("[1] Deposito");
        System.out.println("[2] Retiro");
        System.out.println("[3] Consulta de Saldo");
        System.out.println("[4] Salir");
        System.out.print("Elija una operacion que desa realizar: ");
        opcion = teclado.nextInt();
        switch(opcion)
        {
            case 1:
                System.out.print("Ingrese la cantidad de dinero a depositar: ");
                otraOpcion = teclado.nextDouble();
                Cuenta.deposito(otraOpcion);
                System.out.println("Deposito exitoso...");
                System.out.println();
            break;
            case 2:
                if(Cuenta.consulta() == 0)
                {
                    System.out.println("No tiene fondos para poder retirar");
                }
                    else
                    {
                    System.out.print("Ingrese la cantidad de dinero a retirar: ");
                    otraOpcion  = teclado.nextDouble();
                    if(otraOpcion > Cuenta.consulta())
                    {
                        System.out.println("Lo siento no cuenta con esa cantidad");
                        System.out.println();
                        System.out.println();
                    }    
                        else
                        {
                            Cuenta.retiro(otraOpcion);
                            System.out.println("Retiro exitoso...");
                            System.out.println();
                            System.out.println();
                        }  
                    }
            break;
            case 3:
                if(Cuenta.consulta() <0)
                {
                    System.out.println("No tienes fondos");
                }
                    else
                {
                    System.out.println("Tu saldo actual es de: "+ Cuenta.consulta());
                }
            System.out.println();
            break;
            case 4:
            System.out.println("Tenga un buen dia");
                break;
            default:
                System.out.println("Elija una opcion entre 1 y 4 por favor.");  
        }
    }
}
    public static void main(String[] args) {
        PeruBank ver = new PeruBank();
        ver.Entrada();
    }
}