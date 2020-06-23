package org.kurolek.annotationHibernateStart.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Weapons")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 50)
    private String name;

    @ManyToMany(mappedBy = "weapons")
    private Set<Warrior> warriors = new HashSet<>(0);

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private WeaponDetails weaponDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_type_id")
    private WeaponType weaponType;

    public Weapon(long id) {
        this.id = id;
    }

    public Weapon() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponDetails getWeaponDetails() {
        return weaponDetails;
    }

    public void setWeaponDetails(WeaponDetails weaponDetails) {
        this.weaponDetails = weaponDetails;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}
