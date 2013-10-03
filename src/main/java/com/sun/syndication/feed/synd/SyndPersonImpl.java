/*
 * Copyright 2004 Sun Microsystems, Inc.
 * Copyright 2011 The ROME Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.sun.syndication.feed.synd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.syndication.feed.impl.ObjectBean;
import com.sun.syndication.feed.module.Module;
import com.sun.syndication.feed.module.impl.ModuleUtils;

/**
 * Bean for authors and contributors of SyndFeedImpl feeds and entries.
 * <p>
 * 
 * @author Dave Johnson
 * 
 */
public class SyndPersonImpl implements Serializable, SyndPerson {
    private final ObjectBean _objBean;
    private String _name;
    private String _uri;
    private String _email;
    private List<Module> _modules;

    /**
     * For implementations extending SyndContentImpl to be able to use the
     * ObjectBean functionality with extended interfaces.
     */
    public SyndPersonImpl() {
        this._objBean = new ObjectBean(SyndPerson.class, this);
    }

    /**
     * Creates a deep 'bean' clone of the object.
     * <p>
     * 
     * @return a clone of the object.
     * @throws CloneNotSupportedException thrown if an element of the object
     *             cannot be cloned.
     * 
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return this._objBean.clone();
    }

    /**
     * Indicates whether some other object is "equal to" this one as defined by
     * the Object equals() method.
     * <p>
     * 
     * @param other he reference object with which to compare.
     * @return <b>true</b> if 'this' object is equal to the 'other' object.
     * 
     */
    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof SyndPersonImpl)) {
            return false;
        }
        return this._objBean.equals(other);
    }

    /**
     * Returns a hashcode value for the object.
     * <p>
     * It follows the contract defined by the Object hashCode() method.
     * <p>
     * 
     * @return the hashcode of the bean object.
     * 
     */
    @Override
    public int hashCode() {
        return this._objBean.hashCode();
    }

    /**
     * Returns the String representation for the object.
     * <p>
     * 
     * @return String representation for the object.
     * 
     */
    @Override
    public String toString() {
        return this._objBean.toString();
    }

    /**
     * Returns the person name.
     * <p>
     * 
     * @return the person name, <b>null</b> if none.
     * 
     */
    @Override
    public String getName() {
        return this._name;
    }

    /**
     * Sets the category name.
     * <p>
     * 
     * @param name the category name to set, <b>null</b> if none.
     * 
     */
    @Override
    public void setName(final String name) {
        this._name = name;
    }

    /**
     * Returns the person's e-mail address.
     * <p>
     * 
     * @return the person's e-mail address, <b>null</b> if none.
     * 
     */
    @Override
    public String getEmail() {
        return this._email;
    }

    /**
     * Sets the person's e-mail address.
     * <p>
     * 
     * @param email The person's e-mail address to set, <b>null</b> if none.
     * 
     */
    @Override
    public void setEmail(final String email) {
        this._email = email;
    }

    /**
     * Returns the person's URI.
     * <p>
     * 
     * @return the person's URI, <b>null</b> if none.
     * 
     */
    @Override
    public String getUri() {
        return this._uri;
    }

    /**
     * Sets the person's URI.
     * <p>
     * 
     * @param uri the peron's URI to set, <b>null</b> if none.
     * 
     */
    @Override
    public void setUri(final String uri) {
        this._uri = uri;
    }

    /**
     * Returns the person modules.
     * <p>
     * 
     * @return a list of ModuleImpl elements with the person modules, an empty
     *         list if none.
     */
    @Override
    public List<Module> getModules() {
        if (this._modules == null) {
            this._modules = new ArrayList<Module>();
        }
        return this._modules;
    }

    /**
     * Sets the person modules.
     * <p>
     * 
     * @param modules the list of ModuleImpl elements with the person modules to
     *            set, an empty list or <b>null</b> if none.
     * 
     */
    @Override
    public void setModules(final List<Module> modules) {
        this._modules = modules;
    }

    /**
     * Returns the module identified by a given URI.
     * <p>
     * 
     * @param uri the URI of the ModuleImpl.
     * @return The module with the given URI, <b>null</b> if none.
     */
    @Override
    public Module getModule(final String uri) {
        return ModuleUtils.getModule(getModules(), uri);
    }
}