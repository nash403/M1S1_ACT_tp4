package travellingSalemansProblem;

import classesPb.Certificat;
import classesPb.NP;
import classesPb.NPRed;

public class HamiltonCycleRed extends NPRed {
	public int nbSommets;
	public boolean[][] aretes;

	public HamiltonCycleRed(int nb, boolean[][] arr) {
		this.nbSommets = nb;
		this.aretes = arr;
	}

	@Override
	public NP red() {
		int[][] dist = new int[nbSommets][nbSommets];
		for (int i = 0, l = dist.length; i < l; i++) {
			for (int j = 0; j < l; j++) {
				dist[i][j] = aretes[i][j] ? 1 : nbSommets;
			}
		}
		return new TSP(nbSommets, dist, nbSommets);
	}

	@Override
	public boolean estCorrect(Certificat cert) {

		return red().estCorrect(cert);
	}

}
