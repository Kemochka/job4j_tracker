package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * Поле, содержащее пользователя и его счета
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод, который добавляет нового пользователя
     * @param user пользователь, которого добавят
     */

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя
     * @param passport параметр, по которому удаляется пользователь
     */

    public void deleteUser(String passport) {
            users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счет к пользователю
     * @param passport параметр для поиска пользователя
     * @param account параметр для добавления аккаунта к списку
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод, для поиска поиска пользователя по паспорту
     * @param passport параметр, по которому осуществляется поиск
     * @return если введен верно, вернет пользователя
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод, который ищет счет пользователя по реквизитам
     * @param passport по параметру ищет список аккаунтов
     * @param requisite ищет нужный аккаунт
     * @return если данные верны, то вернет аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод, для совершения переводов с одного счета на другой
     * @param sourcePassport паспорт пользователя, по которому ищется аккаунт
     * @param sourceRequisite реквизиты, по которым идет поиск счета
     * @param destinationPassport паспорт получателя, по которому идет поиск аккаунта
     * @param destinationRequisite реквизиты получателя, по которым идет поиск счета
     * @param amount сумма перевода
     * @return возвращает значение, в зависимости от того, был произведен перевод(true) или нет(false)
     */

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод, для получения списка аккаунтов пользователя
     * @param user пользователь
     * @return возвращает информацию о пользователе и его счетах
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
