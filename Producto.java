class Producto {
    String nombre;
    String codigo;
    String marca;
    float precio;
    int existencias;
    String categoria;

    public Producto(String nombre, String codigo, String marca, float precio, String categoria) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.marca = marca;
        this.precio = precio;
        this.categoria = categoria;
        existencias = 0;
    }

    public void addProduct() {
        existencias++;
    }
    public void deleteProduct() {
        existencias--;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getMarca() {
        return marca;
    }
    public float getPrecio() {
        return precio;
    }
    public float getExistencias() {
        return existencias;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Articulo\n\tnombre: " + nombre + "\n\tcodigo: " + codigo + "\n\tmarca: " + marca + "\n\tprecio: " + precio + "\n\texistencias: " +
               existencias + "\n\tcategoria: " + categoria;
    }
}
