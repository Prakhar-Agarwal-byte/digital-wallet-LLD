package data;

import models.Wallet;

import java.util.ArrayList;
import java.util.List;

public class Db {
    public List<Wallet> wallets = new ArrayList<>();
    private static volatile Db INSTANCE = null;
    private Db() {}

    public static Db getInstance() {
        if (INSTANCE == null) {
            synchronized (Db.class){
                if (INSTANCE == null) {
                    INSTANCE = new Db();
                }
            }
        }
        return INSTANCE;
    }
}
