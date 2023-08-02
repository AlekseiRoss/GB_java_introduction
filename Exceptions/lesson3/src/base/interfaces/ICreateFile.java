package base.interfaces;

import base.exceptions.FileCreateException;

public interface ICreateFile {
    public boolean createFile(String path) throws FileCreateException;
}
