package interfaceexample;

public class VideoPlayer implements Playable, Streamable {

    public void play() {
        System.out.println("VideoPlayer playing video.");
    }

    public void stream() {
        System.out.println("VideoPlayer streaming video.");
    }
}
