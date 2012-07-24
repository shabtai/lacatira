package com.nsn.cloudstreet.users.management;


import com.nsn.cloudstreet.users.model.LabelValue;

import java.util.List;

/**
 * Business Service Interface to talk to persistence layer and
 * retrieve values for drop-down choice lists.
 */
public interface LookupManager {
    /**
     * Retrieves all possible roles from persistence layer
     * @return List of LabelValue objects
     */
    List<LabelValue> getAllRoles();
}
