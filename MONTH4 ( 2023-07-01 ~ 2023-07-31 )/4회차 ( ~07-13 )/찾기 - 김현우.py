import sys

def computeLPS(word, lps):
    suffix = 0
    prefix = 1
    while prefix < len(word):
        if word[prefix] == word[suffix]:
            suffix += 1
            lps[prefix] = suffix
            prefix += 1
        else:
            if suffix != 0:
                suffix = lps[suffix - 1]
            else:
                lps[prefix] = 0
                prefix += 1

def KMP(word, test):
    l_word = len(word)
    l_test = len(test)

    computeLPS(test, lps)

    w_index = 0
    t_index = 0

    while w_index < l_word:
        if test[t_index] == word[w_index]:
            w_index += 1
            t_index += 1
        elif test[t_index] != word[w_index]:
            if t_index != 0:
                t_index = lps[t_index - 1]
            else:
                w_index += 1

        if t_index == l_test:
            ans.append(w_index - t_index + 1)
            t_index = lps[t_index - 1]

word = sys.stdin.readline().rstrip('\n')
test = sys.stdin.readline().rstrip('\n')

ans = []
lps = [0 for _ in range(len(test))]

KMP(word, test)

print(len(ans))
print(*ans)