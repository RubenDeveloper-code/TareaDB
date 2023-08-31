public class ControlProductos {
    String CATEGORIAS[] = {"Perfumes","Accesorios","Calzado","Bolsas", "Ropa deportiva"};//Unknown
    private Producto[] productos;
    private int it;
    private int max;

    public ControlProductos() {
        max=20;
        it=0;
        productos=new Producto[max];
    }
    public boolean comprarArticulo(String nombre) {
        Producto testproducto;
        if((testproducto = buscarProducto(nombre))!=null) {
            testproducto.addProduct();
            return true;
        }
        return false;
    }

    public boolean venderArticulo(String nombre) {
        Producto testproducto;
        if(buscarProducto(nombre)==null)return false;
        if((testproducto = buscarProducto(nombre)).getExistencias() > 0) {
            testproducto.deleteProduct();
            return true;
        } else
            return false;
    }

    public boolean altaCatalogo(Producto producto) {
        if(buscarProducto(producto.getNombre()) != null) return false;
        if(it<max) {
            productos[it++] = producto;
            return true;
        }
        return false;
    }

    public boolean bajaCatalogo(String nombre) {
        int it=0;
        Producto prodstemp[] = new Producto[max];
        for (Producto producto : productos) {
            if(producto==null)continue;
            if(!producto.getNombre().equals(nombre)) {
                prodstemp[it] = producto;
                ++it;
            }
        }
        productos = prodstemp;
        return it < this.it;
    }

    public Producto buscarProducto(String nombreProducto) {
        for(Producto producto: productos) {
            if(producto==null)continue;
            if(producto.getNombre().equals(nombreProducto))return producto;
        }
        return null;
    }

    public void reporteGeneral() {
        reporteCatalogo();
    }

    public void reporteCatalogo() {
        for (Producto producto : productos) {
            if(producto==null)continue;
            System.out.println(producto.toString());
        }
    }

    public void reporteCategoria() {
        for(String categoria : CATEGORIAS) {
            System.out.println("Categoria: " + categoria);
            for(Producto producto : productos) {
                if(producto==null)continue;
                if(producto.getCategoria().toLowerCase().equals(categoria.toLowerCase()) || (producto.getCategoria().charAt(0)) == (categoria.charAt(0)+('a'-'A'))) {
                    System.out.println(producto.toString());
                }
            }
        }
    }
    public void mostrarCategorias() {
        System.out.println("Categorias");
        for (String categoria : CATEGORIAS) {
            System.out.println("\t"+categoria+" "+(((char)(categoria.charAt(0)+('a'-'A')))));
        }
    }

    public boolean categoriaExiste(String _categoria) {
        for(String categoria : CATEGORIAS) {
            if(categoria.toLowerCase().equals(_categoria.toLowerCase()) || categoria.charAt(0) + ('a' - 'A') == _categoria.charAt(0))return true;
        }
        return false;
    }

}
