package com.example.riskipradana.simplemvp;

public class MainPresenter {

    private MainView view;

    private MainModel model;

    MainPresenter(MainView view) {
        this.view = view;
    }

    private double volume(double panjang, double lebar, double tinggi){
        return panjang / lebar * tinggi;
    }

    public void hitungVolume(double panjang, double lebar, double tinggi){

        double volume = volume(panjang, lebar, tinggi);

        model = new MainModel(volume);

        view.showVolume(model);
    }
}
