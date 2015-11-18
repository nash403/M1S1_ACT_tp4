package travellingSalemansProblem;

import java.util.Random;
import java.util.Scanner;

import classesPb.Certificat;

public class CertificatTSP implements Certificat {

	private final TSP donnee;
	public Integer certif[] = null;

	public CertificatTSP(TSP tsp) {
		donnee = tsp;
		certif = new Integer[tsp.nbVilles];
	}

	public Integer[] getCertif() {
		return certif;
	}

	public void setCertif(Integer certif[]) {
		this.certif = certif;
	}

	public void saisie() {
		Scanner sc = new Scanner(System.in);
		setCertif(new Integer[certif.length]);
		for (int i = 0; i < certif.length; i++) {
			certif[i] = new Integer(sc.nextInt());
		}
		sc.close();
		return;
	}

	public void display() {
		int i = 0;
		System.out.print("[");
		for (; i < certif.length - 1; i++) {
			System.out.print(certif[i] + ", ");
		}

		if (i >= 0) {
			System.out.print(certif[i]);
		}

		System.out.println("]");
		return;
	}

	public static Integer[] shuffle(Integer[] arr) {
		Random rgen = new Random();
		for (int i = 0; i < arr.length; i++) {
			int rpos = rgen.nextInt(arr.length);
			Integer tmp = arr[i];
			arr[i] = arr[rpos];
			arr[rpos] = tmp;
		}
		return arr;
	}

	public void alea() {
		setCertif(shuffle(certif));
	}

	public void reset() {
		certif = new Integer[donnee.nbVilles];
		for (int i = 0; i < donnee.nbVilles; i++) {
			certif[i] = i;
		}
		return;
	}

	public boolean estDernier() {
		int k;
		k = -1;
		for (int i = 0; i < certif.length - 1; i++){
			if (certif[i] < certif[i + 1]) {
				k = i;
			}
		}
		return k == -1;
	}

	public void suivant() {
		int k, l;
		k = -1;
		for (int i = 0; i < certif.length - 1; i++){
			if (certif[i] < certif[i + 1]) {
				k = i;
			}
		}
		if (k == -1) return;
		l = k+1;
		for (int j = k+1; j < certif.length; j++){
			if (certif[j] > certif[k]) {
				l = j;
			}
		}
		Integer tmp = certif[k];
		certif[k] = certif[l];
		certif[l] = tmp;
		for (int i = k+1; i < (certif.length+k+1)/2; i++) {
			tmp = certif[i];
			certif[i] = certif[certif.length-i+k];
			certif[certif.length-i+k] = tmp;
		}
	}
}
