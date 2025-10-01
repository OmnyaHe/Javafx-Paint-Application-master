package paint.model;

public class CloneFactory {

    public iShape getClone(iShape shapeSample) {
        try {
            return shapeSample.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}