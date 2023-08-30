package Lesson1.InMemoryModel;

import Lesson1.ModelElements.Camera;
import Lesson1.ModelElements.Flash;
import Lesson1.ModelElements.PoligonalModel;
import Lesson1.ModelElements.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {
    public List<PoligonalModel> Models;
    public List<Scene> Scenes;
    public List<Flash> Flashes;
    public List<Camera> Cameras;
    private List<IModelChangedObserver> changedObserver;

    public ModelStore(List<IModelChangedObserver> changedObserver) throws Exception {
        this.changedObserver = changedObserver;

        this.Models = new ArrayList<>();
        this.Scenes = new ArrayList<>();
        this.Flashes = new ArrayList<>();
        this.Cameras = new ArrayList<>();

        Models.add(new PoligonalModel(null));
        Flashes.add(new Flash());
        Cameras.add(new Camera());
        Scenes.add(new Scene(0, Models, Flashes, Cameras));
    }

    public Scene GetScene(int id) {
        for (int i = 0; i < Scenes.size(); i++) {
            if (Scenes.get(i).id == id) {
                return Scenes.get(i);
            }

        }
        return null;
    }

    @Override
    public void NotifyCange(IModelChanger sender) {

    }
    
}
