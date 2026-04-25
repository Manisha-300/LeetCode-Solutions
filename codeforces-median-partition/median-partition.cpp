#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n;
        scanf("%d", &n);
        vector<int> a(n);
        for (int i = 0; i < n; i++) scanf("%d", &a[i]);

        vector<int> sa(a);
        sort(sa.begin(), sa.end());
        int m = sa[n / 2];

        vector<int> P(n + 1, 0), Q(n + 1, 0);
        for (int i = 0; i < n; i++) {
            P[i + 1] = P[i] + (a[i] > m);
            Q[i + 1] = Q[i] + (a[i] < m);
        }

        vector<int> dp(n + 1, -1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j -= 2) {
                if (dp[j] < 0) continue;
                int half = (i - j) / 2;
                if (P[i] - P[j] <= half && Q[i] - Q[j] <= half) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        printf("%d\n", dp[n]);
    }
    return 0;
}
