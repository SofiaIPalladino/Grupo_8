package modelo;

public abstract class Vehiculo {
    private String patente;
    private int cantMaxPasajeros;
    private boolean petFriendly;
    private boolean baúl;

    public Vehiculo(String patente, int cantMaxPasajeros, boolean petFriendly, boolean baúl) {
        this.patente = patente;
        this.cantMaxPasajeros = cantMaxPasajeros;
        this.petFriendly = petFriendly;
        this.baúl = baúl;
    }


}
