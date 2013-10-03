/*
 * Copyright 2004 Sun Microsystems, Inc.
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
package com.sun.syndication.feed.module;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sun.syndication.feed.CopyFrom;
import com.sun.syndication.feed.impl.CopyFromHelper;

/**
 * Syndication ModuleImpl, default implementation.
 * <p>
 * 
 * @see <a
 *      href="http://web.resource.org/rss/1.0/modules/syndication/">Syndication
 *      module</a>.
 * @author Alejandro Abdelnur
 * 
 */
public class SyModuleImpl extends ModuleImpl implements SyModule {
    private static final Set<String> PERIODS = new HashSet<String>();

    static {
        PERIODS.add(HOURLY);
        PERIODS.add(DAILY);
        PERIODS.add(WEEKLY);
        PERIODS.add(MONTHLY);
        PERIODS.add(YEARLY);
    }

    private String _updatePeriod;
    private int _updateFrequency;
    private Date _updateBase;

    /**
     * Default constructor. All properties are set to <b>null</b>.
     * <p>
     * 
     */
    public SyModuleImpl() {
        super(SyModule.class, URI);
    }

    /**
     * Returns the Syndication module update period.
     * <p>
     * 
     * @return the Syndication module update period, <b>null</b> if none.
     * 
     */
    @Override
    public String getUpdatePeriod() {
        return this._updatePeriod;
    }

    /**
     * Sets the Syndication module update period.
     * <p>
     * 
     * @param updatePeriod the Syndication module update period to set,
     *            <b>null</b> if none.
     * 
     */
    @Override
    public void setUpdatePeriod(final String updatePeriod) {
        if (!PERIODS.contains(updatePeriod)) {
            throw new IllegalArgumentException("Invalid period [" + updatePeriod + "]");
        }
        this._updatePeriod = updatePeriod;
    }

    /**
     * Returns the Syndication module update frequency.
     * <p>
     * 
     * @return the Syndication module update frequency, <b>null</b> if none.
     * 
     */
    @Override
    public int getUpdateFrequency() {
        return this._updateFrequency;
    }

    /**
     * Sets the Syndication module update frequency.
     * <p>
     * 
     * @param updateFrequency the Syndication module update frequency to set,
     *            <b>null</b> if none.
     * 
     */
    @Override
    public void setUpdateFrequency(final int updateFrequency) {
        this._updateFrequency = updateFrequency;
    }

    /**
     * Returns the Syndication module update base date.
     * <p>
     * 
     * @return the Syndication module update base date, <b>null</b> if none.
     * 
     */
    @Override
    public Date getUpdateBase() {
        return new Date(this._updateBase.getTime());
    }

    /**
     * Sets the Syndication module update base date.
     * <p>
     * 
     * @param updateBase the Syndication module update base date to set,
     *            <b>null</b> if none.
     * 
     */
    @Override
    public void setUpdateBase(final Date updateBase) {
        this._updateBase = new Date(updateBase.getTime());
    }

    @Override
    public Class<? extends Module> getInterface() {
        return SyModule.class;
    }

    @Override
    public void copyFrom(final CopyFrom obj) {
        COPY_FROM_HELPER.copy(this, obj);
    }

    private static final CopyFromHelper COPY_FROM_HELPER;

    static {
        final Map basePropInterfaceMap = new HashMap();
        basePropInterfaceMap.put("updatePeriod", String.class);
        basePropInterfaceMap.put("updateFrequency", Integer.TYPE);
        basePropInterfaceMap.put("updateBase", Date.class);

        final Map basePropClassImplMap = Collections.EMPTY_MAP;

        COPY_FROM_HELPER = new CopyFromHelper(SyModule.class, basePropInterfaceMap, basePropClassImplMap);
    }

}