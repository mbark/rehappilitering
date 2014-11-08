package arkbarkberg.rehappilitering;

import java.io.Serializable;

/**
 * Created by Niklas on 08/11/2014.
 */
public class Exercise implements Serializable {

    private String name;
    private String instructions;
    private String videoUrl;

    public Exercise(String name, String instructions, String videoUrl){
        this.name = name;
        this.instructions = instructions;
        this.videoUrl = videoUrl;
    }

    public String getName(){
        return name;
    }

    public String getInstructions(){
        return instructions;
    }

    public String getVideoUrl(){
        return videoUrl;
    }
}
