package classesPb;

abstract public class NPRed extends NP {

	abstract public NP red();

	public Certificat cert() {
		return red().cert();
	}
}