package ar.edu.ar.ort.parcial2.clases;

public enum ServicioAdicional {
    DESAYUNO(20),
    SPA(50),
    GIMNASIO(30),
    WIFI(10);

    private final float costoExtra;

    ServicioAdicional(float costoExtra) {
        this.costoExtra = costoExtra;
    }

    public float getCostoExtra() {
        return costoExtra;
    }
}