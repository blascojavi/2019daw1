package Negocio;

import Modelo.Cliente;
import Modelo.Lavadora;
import Modelo.Mayorista;
import Modelo.Mueble;
import Modelo.Particular;
import Modelo.Producto;
import Modelo.Televisor;
import Modelo.TipoMayorista;

import java.text.ParseException;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Scanner;


public class MenuPrincipal {

    private NegociosService servicio;

    MenuPrincipal() {

        servicio = new NegociosService();
    }

    public void inciarAplicacion() {
        try {
            // menu Principal
            int opcion = -1;
            do {
                System.out.println("\nGESTION DEL ALMACEN Mislata");
                System.out.println("1.Productos");
                System.out.println("2.Clientes");
                System.out.println("3.Ventas");
                System.out.println("0.Para Salir");
                System.out.println("Introduzca la opcion");
                Scanner sc = new Scanner(System.in);
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion == 1) {
                    menuProductos();
                }
                if (opcion == 2) {
                    menuClientes();
                }
                if (opcion == 3) {
                    menuVentas();
                }

            } while (opcion != 0);

            System.out.println("Gracias por usar nuestra aplicacion");
            System.out.println("Hasta la proxima");

        } catch (Exception e) {
            System.out.println("Opcion no valida");
            this.inciarAplicacion();
        }
    }

    private void menuProductos() {
        try {
            int opcionProductos = -1;
            do {
                System.out.println("1.Introducir Producto");
                System.out.println("2.Dar de baja un producto");
                System.out.println("3.Imprimir los datos de un producto");
                System.out.println("4.Imprimir todos los productos");
                System.out.println("0. Salir del menu");
                Scanner sc = new Scanner(System.in);
                opcionProductos = Integer.parseInt(sc.nextLine());
                
                if (opcionProductos == 1) {
                    Producto p = datosProducto();
                    servicio.introducirProducto(p);
                }
                if (opcionProductos == 2) {
                    System.out.println("Introduzca el número de producto: ");
                    int num = Integer.parseInt(sc.nextLine());
                    servicio.elimninarProducto(num);
                }
                if (opcionProductos == 3) {
                    System.out.println("Introduzca el número de producto: ");
                    int nprod = Integer.parseInt(sc.nextLine());
                    System.out.println(servicio.buscarProducto(nprod));
                }
                if (opcionProductos == 4) {
                    System.out.println(servicio.imprimirTodosProductos());
                }

            } while (opcionProductos != 0);
        } catch (Exception e) {
            System.out.println("Opcion no valida" + e.getMessage());
            this.menuProductos();
        }
    }

    public Producto datosProducto() throws Exception {
        Scanner sc = new Scanner(System.in);
        Producto producto = null;
        String nombre;
        double precio;
        int opcion = -1;
        do {
            System.out.println("Introduzca el nombre: ");
            nombre = sc.nextLine();

            System.out.println("Introduzca precio base: ");
            precio = Double.parseDouble(sc.nextLine());

            System.out.println("Introduzca el tipo de producto: ");
            System.out.println("1. Mueble");
            System.out.println("2. Lavadora");
            System.out.println("3. Televisor");
            opcion = Integer.parseInt(sc.nextLine());
            if (opcion == 1) {
                producto = pedirMueble();
            }
            if (opcion == 2) {
                producto = pedirLavadora();
            }
            if (opcion == 3) {
                producto = pedirTelevisor();
            }
            if (producto != null) {
                producto.setNombre(nombre);
                producto.setPrecio(precio);
            }

        } while (opcion != 1 && opcion != 2 && opcion != 3);

        return producto;
    }

    public Mueble pedirMueble() throws ParseException {
        Mueble m = new Mueble();
        Scanner sc = new Scanner(System.in);

        m.setTipoMadera(pedirMadera());

        System.out.println("Introduzca el estilo:");
        m.setEstilo(sc.nextLine());

        System.out.println("Introduzca la fecha (dd/MM/yyyy): ");
       try{
        m.setAnyoFab(this.validarFecha(sc.nextLine()));
       }catch(FormatoFechaErroneo e ){
           System.out.println(e);
           m.setAnyoFab(null);
        }

        return m;

    }

    public Lavadora pedirLavadora() {
        Scanner sc = new Scanner(System.in);
        Lavadora l = new Lavadora();

        System.out.println("Introduzca fabricante : ");
        l.setFabricante(sc.nextLine());

        System.out.println("Introduzca marca : ");
        l.setMarca(sc.nextLine());

        System.out.println("Introduzca las revoluciones(rpm): ");
        int rev = Integer.parseInt(sc.nextLine());
        l.setRevoluciones(rev);

        System.out.println("Introduzca la capacidad (kg): ");
        int c = Integer.parseInt(sc.nextLine());
        l.setCarga(c);

        return l;
    }

    public Televisor pedirTelevisor() {
        Televisor tv = new Televisor();
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca fabricante : ");
        tv.setFabricante(sc.nextLine());

        System.out.println("Introduzca marca : ");
        tv.setMarca(sc.nextLine());

        System.out.println("Introduzca las pulgadas: ");
        double pulgadas = Double.parseDouble(sc.nextLine());
        tv.setPulgadas(pulgadas);

        System.out.println("Introduzca el tipo: ");
        tv.setTipo(sc.nextLine());

        return tv;
    }

    private Mueble.Madera pedirMadera() {
        Mueble.Madera m = null;
        String opcion;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduzca el tipo de Madera");
            System.out.println("1.Pino");
            System.out.println("2.Roble");
            System.out.println("3.Haya");

            opcion = sc.nextLine();

        } while (!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("1"));

        if (opcion.equals("1")) {
            m = Mueble.Madera.PINO;
        }
        if (opcion.equals("2")) {
            m = Mueble.Madera.ROBLE;
        }
        if (opcion.equals("3")) {
            m = Mueble.Madera.HAYA;
        }
        return m;
    }

    private void menuClientes() {
        Scanner sc = new Scanner(System.in);

        try {
            int opcionClientes = -1;
            do {
                System.out.println("1.Introducir Cliente");
                System.out.println("2.Dar de baja un cliente");
                System.out.println("3.Imprimir los datos de un cliente");
                System.out.println("4.Imprimir todos los clientes");
                System.out.println("0. Salir del menu");

                opcionClientes = Integer.parseInt(sc.nextLine());
                if (opcionClientes == 1) {
                    Cliente c = pedirCliente();
                    servicio.introducirCliente(c);
                }
                if (opcionClientes == 2) {
                    System.out.println("Introduzca el número de cliente.");
                    int n = Integer.parseInt(sc.nextLine());
                    servicio.eliminarCliente(n);

                }
                if (opcionClientes == 3) {
                    System.out.println("Introduzca número de cliente.");
                    int n = Integer.parseInt(sc.nextLine());
                    Cliente c1 = servicio.buscarCliente(n);
                    System.out.println(c1.imprimir());

                }
                if (opcionClientes == 4) {
                    System.out.println(servicio.imprimirTodosClientes());
                }

            } while (opcionClientes != 0);
        } catch (Exception e) {
            System.out.println("Opcion no valida");
            this.menuClientes();
        }

    }

    public Cliente pedirCliente() {
        Cliente c = null;
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String rz = "";
        String opcion;

        try {
            do {
                System.out.println("Introduzca el nombre del cliente: ");
                nombre = sc.nextLine();
                System.out.println("Introduzca la razón social del cliente");
                rz = sc.nextLine();
                System.out.println("Introduzca el tipo de cliente: ");
                System.out.println("1. Mayorista.");
                System.out.println("2. Particular.");
                opcion = sc.next();

                if (opcion.equals("1")) {
                    c = pedirMayorista();
                    c.setNombre(nombre);
                    c.setRazonSocial(rz);
                }
                if (opcion.equals("2")) {
                    c = pedirParticular();
                    c.setNombre(nombre);
                    c.setRazonSocial(rz);
                }
            } while (!opcion.equals("1") && !opcion.equals("2"));

        } catch (Exception e) {
            System.out.println("ERROR AL INTRODUCIR EL CLIENTE" + e.getMessage());
        }

        return c;

    }

    public Mayorista pedirMayorista() {
        Mayorista m = new Mayorista();
        String cif = "";
        double desc = 0;
        TipoMayorista tipo = null;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduzca el CIF");
            cif = sc.nextLine();

            System.out.println("Introduzca el descuento: ");
            desc = Double.parseDouble(sc.nextLine());

            tipo = pedirTipoM();
            m.setDescuento(desc);
            m.setCif(cif);
            m.setTipoMayorista(tipo);
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        return m;
    }

    public Particular pedirParticular() {
        Scanner sc = new Scanner(System.in);
        Particular p = new Particular();

        try {
            System.out.println("Introduzca dni: ");
            String dni = sc.nextLine();
            p.setDni(dni);
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage());
        }

        return p;
    }

    private TipoMayorista pedirTipoM() {
        Scanner sc = new Scanner(System.in);
        TipoMayorista tipo = null;
        int opcion = -1;

        try {
            System.out.println("Elija una opción: ");
            System.out.println("1. Gran Superficie.");
            System.out.println("2. Tienda.");
            opcion = Integer.parseInt(sc.nextLine());
            if (opcion == 1) {
                tipo = TipoMayorista.GRAN_SUPERFICIE;
            }
            if (opcion == 2) {
                tipo = TipoMayorista.TIENDA;
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
        return tipo;
    }

    private void menuVentas() {
        Scanner sc = new Scanner(System.in);

        try {
            String opcionVentas = "-1";
            do {
                System.out.println("1.Introducir Venta");
                System.out.println("2.Dar de baja una venta");
                System.out.println("3.Imprimir los datos de una venta");
                System.out.println("4.Imprimir todas las ventas");
                System.out.println("0. Salir del menu");
                opcionVentas = sc.nextLine();

                if (opcionVentas.equals("1")) {
                    System.out.println("Introduce el número de cliente.");
                    int nc = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce el número de producto.");
                    int np = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce el nombre del vendedor: ");
                    String v = sc.nextLine();
                    servicio.introducirVenta(nc, np, v);
                }
                if (opcionVentas.equals("2")) {
                    System.out.println("Introduzca número de venta: ");
                    int nv = Integer.parseInt(sc.nextLine());
                    servicio.eliminarVenta(nv);
                }
                if (opcionVentas.equals("3")) {
                    System.out.println("Introduzca número de venta: ");
                    int nv = Integer.parseInt(sc.nextLine());
                    servicio.buscarVenta(nv);
                }
                if (opcionVentas.equals("4")) {
                    System.out.println(servicio.imprimirtodasVentas());
                }

            } while (!opcionVentas.equals("0"));

        } catch (Exception e) {
            System.out.println("Opcion no valida");
            this.menuVentas();
        }

    }

    private LocalDate validarFecha(String fecha)  { //TODO: validacion de fecha
        DateTimeFormatter patronFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fec ;
        try{
                fec = LocalDate.parse(fecha , patronFecha);
        }catch(DateTimeParseException e){
            throw new FormatoFechaErroneo(fecha + " dd-MMMM-yy");

        }
        return fec;
    }

}
