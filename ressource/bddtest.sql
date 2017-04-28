-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 28 Avril 2017 à 14:25
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bddtest`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id` bigint(20) NOT NULL,
  `dateCreation` datetime DEFAULT NULL,
  `numAgence` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `cartebancaire`
--

CREATE TABLE `cartebancaire` (
  `type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `bloquee` bit(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `dateOuverture` datetime DEFAULT NULL,
  `numeroCompte` int(11) NOT NULL,
  `solde` double NOT NULL,
  `remuneration` double DEFAULT NULL,
  `decouvert` double DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `compte_cartebancaire`
--

CREATE TABLE `compte_cartebancaire` (
  `Compte_id` bigint(20) NOT NULL,
  `carteBancaires_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `coordonnees`
--

CREATE TABLE `coordonnees` (
  `id` bigint(20) NOT NULL,
  `cp` varchar(255) DEFAULT NULL,
  `numRue` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `coordonnees`
--

INSERT INTO `coordonnees` (`id`, `cp`, `numRue`, `ville`) VALUES
(1, '01234', '1 rue 1', 'Ville 1'),
(2, '02345', '2 rue 2', 'Ville 2'),
(3, '01010', '3 rue 3', 'Ville 3');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `type` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `entreprise` bit(1) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `conseiller_id` bigint(20) DEFAULT NULL,
  `coordonnees_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`type`, `id`, `nom`, `prenom`, `email`, `entreprise`, `telephone`, `login`, `pwd`, `conseiller_id`, `coordonnees_id`) VALUES
('conseiller', 1, 'nomcons1', 'prenomcons1', NULL, NULL, NULL, 'login1', 'pwd1', NULL, NULL),
('conseiller', 2, 'nomcons2', 'prenomcons2', NULL, NULL, NULL, 'login2', 'pwd2', NULL, NULL),
('client', 3, 'nomcli3', 'prenomcli3', 'cli3@mail.com', b'0', '0123456789', NULL, NULL, 1, 1),
('client', 4, 'nomcli4', 'prenomcli4', 'cli4@mail.com', b'0', '0234567891', NULL, NULL, 1, 2),
('client', 5, 'nomcli6', 'prenomcli6', 'cli6@mail.com', b'1', '0345678912', NULL, NULL, 2, 1),
('client', 6, 'nomcli7', 'prenomcli7', 'cli7@mail.com', b'1', '0101010101', NULL, NULL, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `personne_personne`
--

CREATE TABLE `personne_personne` (
  `Personne_id` bigint(20) NOT NULL,
  `conseillers_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `personne_placement`
--

CREATE TABLE `personne_placement` (
  `Personne_id` bigint(20) NOT NULL,
  `placements_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `placement`
--

CREATE TABLE `placement` (
  `id` bigint(20) NOT NULL,
  `montant` double NOT NULL,
  `placeFinanciere` varchar(255) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_jypo7b7k528n3pbpm0armju7y` (`client_id`);

--
-- Index pour la table `compte_cartebancaire`
--
ALTER TABLE `compte_cartebancaire`
  ADD UNIQUE KEY `UK_eshlrguoauch0nisj05x3q4fx` (`carteBancaires_id`),
  ADD KEY `FK_swsirfmgwn9k4n11luvinn03a` (`Compte_id`);

--
-- Index pour la table `coordonnees`
--
ALTER TABLE `coordonnees`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_dorgrgheop46kc1y0o9evdfav` (`conseiller_id`),
  ADD KEY `FK_lqohniaqc94ekaia8mado1tal` (`coordonnees_id`);

--
-- Index pour la table `personne_personne`
--
ALTER TABLE `personne_personne`
  ADD UNIQUE KEY `UK_nkmv6vk21onsmp2a2gu08ascb` (`conseillers_id`),
  ADD KEY `FK_6t73h1kp1mwgxxgbe36a99wxv` (`Personne_id`);

--
-- Index pour la table `personne_placement`
--
ALTER TABLE `personne_placement`
  ADD UNIQUE KEY `UK_letxslux41l7ndtkg5btmm0qk` (`placements_id`),
  ADD KEY `FK_hxxmntxbejg7dhc4ik6uloudl` (`Personne_id`);

--
-- Index pour la table `placement`
--
ALTER TABLE `placement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_2n1jdotkvt0nkes4xyb7hx89w` (`client_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `coordonnees`
--
ALTER TABLE `coordonnees`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
--
-- AUTO_INCREMENT pour la table `placement`
--
ALTER TABLE `placement`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
