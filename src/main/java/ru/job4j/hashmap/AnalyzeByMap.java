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
                   map.merge(subject.name(), subject.score(), Integer::sum);
                }
            }
            List<Label> averageScores = new ArrayList<>();
            for (String key : map.keySet()) {
                averageScores.add(new Label(key, (double) map.get(key) / pupils.size()));
            }
            return averageScores;
        }

        public static Label bestStudent(List<Pupil> pupils) {
            String bestStudentName = "";
            double maxScore = Double.MIN_VALUE;
            for (Pupil pupil : pupils) {
                double totalScore = 0;
                for (Subject subject : pupil.subjects()) {
                    totalScore += subject.score();
                }
                if (totalScore > maxScore) {
                    maxScore = totalScore;
                    bestStudentName = pupil.name();
                }
            }
            return new Label(bestStudentName, maxScore);
        }

        public static Label bestSubject(List<Pupil> pupils) {
            Map<String, Double> map = new LinkedHashMap<>();
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    map.merge(subject.name(), (double) subject.score(), Double::sum);
                }
            }
            Label maxLabel = null;
            double maxScore = Double.MIN_VALUE;
            for (String key : map.keySet()) {
                double score = map.get(key);
                if (score > maxScore) {
                    maxScore = score;
                    maxLabel = new Label(key, score);
                }
            }
            return maxLabel;
        }
    }
