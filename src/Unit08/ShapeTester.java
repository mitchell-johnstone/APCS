package Unit08;

public class ShapeTester {
    public static void main(String[] args) {
        double r = 3.66;
        double h = 8.03;
        System.out.println("Using the Geometry Class:\n\n");
        System.out.println("Radius: " + r);
        System.out.println("Height: " + h);
        System.out.println("\nSphere volume:");
        System.out.println(Geometry.sphereVolume(r));
        System.out.println("Sphere surface:");
        System.out.println(Geometry.sphereSurface(r));
        System.out.println("\nCone volume:");
        System.out.println(Geometry.coneVolume(r,h));
        System.out.println("Cone surface:");
        System.out.println(Geometry.coneSurface(r,h));
        System.out.println("\nCylinder Volume:");
        System.out.println(Geometry.cylinderVolume(r,h));
        System.out.println("Cylinder surface:");
        System.out.println(Geometry.cylinderSurface(r,h));

        Sphere sphere = new Sphere(r);
        Cylinder cylinder = new Cylinder(r,h);
        Cone cone = new Cone(r,h);
        System.out.println("\n\nUsing separate Classes:\n\n");
        System.out.println("Radius: " + r);
        System.out.println("Height: " + h);
        System.out.println("\nSphere volume:");
        System.out.println(sphere.volume());
        System.out.println("Sphere surface:");
        System.out.println(sphere.surface());
        System.out.println("\nCone volume:");
        System.out.println(cone.volume());
        System.out.println("Cone surface:");
        System.out.println(cone.surface());
        System.out.println("\nCylinder Volume:");
        System.out.println(cylinder.volume());
        System.out.println("Cylinder surface:");
        System.out.println(cylinder.surface());


    }
}
