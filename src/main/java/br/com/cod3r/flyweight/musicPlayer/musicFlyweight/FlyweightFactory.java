package br.com.cod3r.flyweight.musicPlayer.musicFlyweight;

import br.com.cod3r.flyweight.musicPlayer.model.Music;
import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static FlyweightFactory singletonInstance = new FlyweightFactory();
    private static Map<String, MusicFlyweight> musicFlyRepository;

    private FlyweightFactory() {
        musicFlyRepository = new HashMap<String, MusicFlyweight>();
    }

    public static FlyweightFactory getInstance() {
        return singletonInstance;
    }

    public MusicFlyweight getMusic(String desc) {
        MusicFlyweight mf = musicFlyRepository.get(desc);

        if (mf == null) {
            System.out.println("Creating new flyweight for " + desc);
            mf = getMusicByString(desc);
            musicFlyRepository.put(desc, mf);
        }
        return mf;
    }

    private MusicFlyweight getMusicByString(String desc) {
        String[] musicData = desc.split(";");
        return new MusicFlyweight(musicData[0], musicData[1], new Integer(musicData[2]));
    }
}
