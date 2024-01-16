package ru.job4j.hashmap;

import java.util.*;

    public class AnalyzeByMap {
        public static double averageScore(List<Pupil> pupils) {
            double totalScore = 0;
            int totalSubjects = 0;
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    totalScore += subject.score();
                    totalSubjects++;
                }
            }
            return totalScore / totalSubjects;
        }

        public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
            List<Label> averageScores = new ArrayList<>();
            for (Pupil pupil : pupils) {
                double totalScore = 0;
                for (Subject subject : pupil.subjects()) {
                    totalScore += subject.score();
                }
                double averageScore = totalScore / pupil.subjects().size();
                averageScores.add(new Label(pupil.name(), averageScore));
            }
            return averageScores;
        }

        public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
            Map<String, Integer> map = new LinkedHashMap<>();
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                   map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
                }
            }
            List<Label> averageScores = new ArrayList<>();
            for (String key : map.keySet()) {
                averageScores.add(new Label(key, (double) map.get(key) / pupils.size()));
            }
            return averageScores;
        }

        public static Label bestStudent(List<Pupil> pupils) {
            List<Label> label = new ArrayList<>();
            for (Pupil pupil : pupils) {
                double totalScore = 0;
                for (Subject subject : pupil.subjects()) {
                    totalScore += subject.score();
                    label.add(new Label(pupil.name(), totalScore));
                }
                label.sort(Comparator.naturalOrder());
            }
            return label.get(label.size() - 1);
        }

        public static Label bestSubject(List<Pupil> pupils) {
            Map<String, Double> map = new LinkedHashMap<>();
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    map.put(subject.name(), map.getOrDefault(subject.name(), 0.0) + subject.score());
                }
            }
            List<Label> labels = new ArrayList<>();
            for (String key : map.keySet()) {
                labels.add(new Label(key, map.get(key)));
                labels.sort(Comparator.naturalOrder());
            }
            return labels.get(labels.size() - 1);
        }
    }
