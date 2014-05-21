package org.ftd.samples.ejb.remote;

import javax.ejb.Remote;


@Remote
public interface SorteadorBeanRemote {
    int sortear();
}
