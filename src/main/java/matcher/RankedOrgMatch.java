package matcher;

import entities.Org;

/**
 * Created by shybovycha on 13/05/16.
 */
public class RankedOrgMatch {
    private Org org;
    private Integer rank;

    public RankedOrgMatch(Org org, Integer rank) {
        this.org = org;
        this.rank = rank;
    }

    public Org getOrg() {
        return org;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.org.getName(), this.rank);
    }
}
