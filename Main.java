import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ControlProductos controlProductos = new ControlProductos();
    public static void main(String[] args) {
        int option;
        do {
            Menu(option = mostrarMenuObtenerOpcion());
        } while(option != 3);

    }
    public static void Menu(int option) {
        switch(option) {
        case 1:
            selectCatalogo(mostrarMenuObtenerOpcionCatalogo());
            break;
        case 2:
            selectMovimientos(mostrarMenuObtenerOpcionMovimentos());
            break;
        case 3:
            return;
        default:
            System.out.println("Opcion " + option + " invalida");
            break;
        }

    }

    public static void selectCatalogo(int option) {
        switch(option) {
        case 1:
            if(!controlProductos.altaCatalogo(formProducto())) {
                System.out.println(">>>Catalogo lleno o producto existente");
            }
            break;
        case 2:
            System.out.print("Nombre: ");
            if(!controlProductos.bajaCatalogo(scanner.next())) {
                System.out.println(">>>Catalogo producto inexistente");
            }
            break;
        case 3:
            Producto producto;
            System.out.print("Nombre: ");
            if((producto = controlProductos.buscarProducto(scanner.next()))!=null) {
                System.out.println(producto.toString());
            } else
                System.out.println(">>>Producto no encontrado");
            break;
        case 4:
            controlProductos.reporteCatalogo();
            break;
        default:
            System.out.println("Opcion " + option + " invalida");
            break;
        }

    }

    public static void selectMovimientos(int option) {
        switch(option) {
        case 1:
            System.out.print("Nombre: ");
            if(!controlProductos.comprarArticulo(scanner.next())) {
                System.out.println("Articulo desconocido, considere darlo de alta");
            }
            break;
        case 2:
            System.out.print("Nombre: ");
            if(!controlProductos.venderArticulo(scanner.next())) {
                System.out.println("Articulo desconocido o ya sin existencias");
            }
            break;
        case 3:
            controlProductos.reporteGeneral();
            break;
        case 4:
            controlProductos.reporteCategoria();
            break;
        default:
            System.out.println("Opcion " + option + " invalida");
            break;
        }
    }

    public static Producto formProducto() {
        String marca,codigo,nombre,categoria;
        float precio;
        System.out.print("Nombre: ");
        nombre = scanner.next();
        System.out.print("Marca: ");
        marca = scanner.next();
        System.out.print("Codigo: ");
        codigo = scanner.next();
        System.out.print("Precio: ");
        precio = I_getInt();
        controlProductos.mostrarCategorias();
        System.out.print("Categoria: ");
        categoria = scanner.next();
        if(!controlProductos.categoriaExiste(categoria)) {
            System.out.println("categoria no existe");
            categoria = "Unknown";
        }
        return new Producto(nombre, codigo, marca, precio, categoria);
    }
    public static int mostrarMenuObtenerOpcion() {
        System.out.println("[1] Menu Catalogo");
        System.out.println("[2] Menu Movimientos");
        System.out.println("[3] Salir");
        System.out.print(">>");
        return I_getInt();
    }

    public static int mostrarMenuObtenerOpcionCatalogo() {
        System.out.println("\t[1] Alta");
        System.out.println("\t[2] Baja");
        System.out.println("\t[3] Buscar");
        System.out.println("\t[4] Reporte general");
        System.out.println("\t[5] Salir");
        System.out.print(">>");
        return I_getInt();
    }
    public static int mostrarMenuObtenerOpcionMovimentos() {
        System.out.println("\t[1] Comprar");
        System.out.println("\t[2] Vender");
        System.out.println("\t[3] Reporte general");
        System.out.println("\t[4] Reporte categoria");
        System.out.println("\t[5] Salir");
        System.out.print(">>");
        return I_getInt();
    }

    public static int I_getInt() {
        while(true) {
            try {
                int number = Integer.parseInt(scanner.next());
                return number;
            } catch(NumberFormatException e) {
                System.out.print("\n>>Ingrese un entero: ");
            }
        }
    }

}
