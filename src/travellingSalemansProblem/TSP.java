package travellingSalemansProblem;

import classesPb.*;

public class TSP extends NP {
	public int nbVilles;
	public int[][] distances;
	public int longueurTournee;

	public TSP(int nb, int dist[][], int lg) {
		this.nbVilles = nb;
		this.distances = dist;
		this.longueurTournee = lg;
	}

	public CertificatTSP cert() {
		return new CertificatTSP(this);
	}

	public boolean estCorrect(Certificat c) {
		int res = 0;
		CertificatTSP cert = (CertificatTSP) c;
		for (int i = 0; i < cert.certif.length - 1; i++) {
			res += distances[cert.certif[i]][cert.certif[i + 1]];
			if (res > longueurTournee)
				return false;
		}
		if (cert.certif.length - 1 >= 0)
			res += distances[cert.certif[cert.certif.length - 1]][cert.certif[0]];
		return res <= longueurTournee;
	}
}