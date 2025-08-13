package interfaceexample;

public class Main {

    public static void main(String[] args) {
        
        Playable p1 = new AudioPlayer();
        p1.play();
        
        Recordable r1 = new AudioPlayer();
        r1.record();

        Playable p2 = new VideoPlayer();
        p2.play();

        Streamable s1 = new VideoPlayer();
        s1.stream();

        Recordable r2 = new Camera();
        r2.record();

        Streamable camerastream = new Camera();
        camerastream.stream();
    }
}
