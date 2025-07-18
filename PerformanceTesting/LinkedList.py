import matplotlib.pyplot as plt
import matplotlib.ticker as mticker
import csv
from collections import defaultdict

def read_csv(filename):
    data = defaultdict(list)
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames if h.lower() != 'size']
        for row in reader:
            size = int(row['Size'].strip('"'))
            for header in headers:
                val_str = row.get(f'"{header}"') or row.get(header) or ''
                try:
                    val = int(val_str.strip('"'))
                except ValueError:
                    val = 0
                data[header].append((size, val))
    return data

# Load LinkedList performance data
data = read_csv('LinkedList_performance.csv')
methods = sorted(data.keys())
sizes = sorted([size for size, _ in data[methods[0]]])
x_max = max(sizes)
# Assumes consistent sizes across all methods
x_ticks = list(range(2500, x_max + 1, 100000))

# Plotting setup
fig, axes = plt.subplots(nrows=len(methods), ncols=1, figsize=(10, 4 * len(methods)))
if len(methods) == 1:
    axes = [axes]

for idx, method in enumerate(methods):
    ax = axes[idx]
    times = [time for _, time in data[method]]

    ax.plot(sizes, times, label='LinkedList', linestyle='-', linewidth=1.5)
    ax.set_title(method)
    ax.set_xlabel('Input Size')
    ax.set_ylabel('Time (ns)')
    ax.legend()
    ax.grid(True)

    x_max = max(sizes)
    y_max = max(times, default=1)

    # Set consistent ticks every 100,000
    ax.set_xlim(0, x_max)
    ax.set_ylim(0, y_max * 1.1)
    ax.set_xticks(x_ticks)
    ax.set_xticklabels([f"{tick:,}" for tick in x_ticks], rotation=45, ha='right')
    ax.xaxis.set_major_formatter(mticker.FuncFormatter(lambda x, _: f"{int(x):,}"))
    ax.yaxis.set_major_formatter(mticker.ScalarFormatter())

plt.tight_layout()
plt.savefig('LinkedList_Performance_Charts.png', dpi=300, bbox_inches='tight')
plt.close()

print("LinkedList chart saved as 'LinkedList_Performance_Charts.png'")
