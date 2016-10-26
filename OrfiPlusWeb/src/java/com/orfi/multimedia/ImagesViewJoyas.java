package com.orfi.multimedia;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ImagesViewJoyas {

    private List<String> images;
    

    @PostConstruct
    public void init() {
        String nombre,prejifo;
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("joyas/anillo" + i + ".jpg");
        }
        for (int i = 1; i <= 4; i++) {
            images.add("joyas/aretes" + i + ".jpg");
        }
        for (int i = 1; i <= 4; i++) {
            images.add("joyas/cadena" + i + ".jpg");
        }
        for (int i = 1; i <= 4; i++) {
            images.add("joyas/pulsera" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}
